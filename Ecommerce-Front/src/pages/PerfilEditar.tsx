import { useContext } from "react";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import { UserContext } from "../context/userContext";
import { useForm } from "react-hook-form";
import axios from "axios";

const API_URL = 'http://localhost:8080';


export function EditarPerfil(){
    const { user, userLogin } = useContext(UserContext);
	const { register, handleSubmit } = useForm(); 
	const updateUserData =  async (formValues : any) => {   
        console.log(formValues);
       
            const response = await axios.put(API_URL + "/loja/perfil/editar", formValues);
            console.log(response);
			
			userLogin(response.data)

            return response;
    }
   
    return(
        <>
        <Header></Header>
        <section id="section-principal">
		<div id="cadastro">
			<span id="accountIcon" className="material-symbols-outlined">account_circle</span>
			<h1>Alterar meus dados</h1>
			<p>É possivel alterar apenas Nome e Telefone.</p>
			<form name="formEditar" onSubmit={handleSubmit(updateUserData)}>
					<input id="idCliente" {...register("idCliente")} type="hidden" required  value={user.cod_cli}/>
					<label htmlFor="nome">Nome: </label>
					<input id="nome" {...register("nome")} type="text" maxLength={255} required placeholder="Nome" defaultValue={user.nome_cli}/>
					
					<label htmlFor="cpf">CPF: </label>
					<input id="cpf" {...register("cpf")} type="text" maxLength={255} required placeholder="CPF *" value={user.cpf_cli} readOnly={true}/>
					
					<label htmlFor="telefone">Telefone: </label>
					<input id="telefone" {...register("telefone")} type="tel" required placeholder={user.tel_cli} defaultValue={user.tel_cli}/>
					
					<label htmlFor="email">Email: </label>
					<input id="email" {...register("email")} type="email" required maxLength={255} placeholder="Email *" value={user.email_cli} readOnly={true}/>
					
					<button id="editar" type="submit">Confirmar</button>
			</form>
		</div>
	    </section>
        <Footer></Footer>
        </>
    )
}