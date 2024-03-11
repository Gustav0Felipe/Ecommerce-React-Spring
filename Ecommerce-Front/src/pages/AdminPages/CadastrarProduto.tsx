import { useState } from "react";
import { Footer } from "../../components/footer/footer";
import Header from "../../components/header/header";
import { useProductMutate } from "../../hooks/useProductDataMutate";
import { ProductDataDto } from "../../interface/ProductDataDto";


const Input = ({id, name, label, inputValue, maxlength, type, placeholder, updateValue} : any) => {
    return(
        <>
        <label htmlFor={name}>{label}</label>
        <input id={id} name={name} value={inputValue} type={type} maxLength={maxlength} required placeholder={placeholder} onChange={event => updateValue(event.target.value)}></input>
        </>
    )
}

export function CadastrarProduto(){
    const [nome, setNome] = useState("");
    const [desc, setDesc] = useState("");
    const [custo, setCusto] = useState(0);
    const [valor, setValor] = useState(0);
    const [estoque, setEstoque] = useState(0);
    const [categoria, setCategoria] = useState(0);
    const [imagem , setImagem] = useState("");

    const { mutate } = useProductMutate();

   
    const submit = () => {
        const productData : ProductDataDto = {
            imagem: imagem,
            nome: nome,
            desc: desc,
            custo: custo,
            valor: valor,
            estoque: estoque,
            categoria: categoria
        }
        mutate(productData);
    }

    return (
    <>
    <Header></Header>
    <section id="section-principal">
        <div id="cadastro">
            <span id="createUserIcon" className="material-symbols-outlined">person_add</span>
            <h1>Novo produto: </h1>
            <form className="formDados">
                        
                <Input label="Nome: " id="nome" name="nome" inputValue={nome} updateValue={setNome} type="text" maxlength={255} placeholder="Nome"/>
                
                <Input label="Descrição: " id="desc" name="desc" inputValue={desc} updateValue={setDesc} maxlength={255} placeholder="descrição"/>
                
                <Input label="Custo: " id="custo" name="custo" inputValue={custo} updateValue={setCusto} type="number" maxlength={10} placeholder="Custo *" autoComplete={"on"}/>
                
                <Input label="Valor: " id="valor" name="valor" inputValue={valor} updateValue={setValor} type="number" maxlength={10} placeholder="Valor *"/>
                
                <Input label="Estoque Inicial: " id="estoque" name="estoque" inputValue={estoque} updateValue={setEstoque} type="number" maxlength={10} placeholder="Estoque *"/>
                
                <Input label="Categoria: " id="categoria" name="categoria" inputValue={categoria} updateValue={setCategoria} type="number" maxlength={10} placeholder="Categoria *"/>
                
                <Input label="Imagem: " id="imagem" name="imagem" inputValue={imagem} updateValue={setImagem} type="text" maxlength={255} placeholder="Imagem *"/>
            <button id="cadastrar" onClick={submit}>Enviar</button>
            </form>
        </div>
    </section>
    <Footer></Footer>
    </>
    );
    
}