import { useContext } from "react"
import { UserContext } from "../context/userContext";
import { useForm } from "react-hook-form";
import axios from "axios";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";

const API_URL = 'http://localhost:8080';

export function AutenticarSenha(){
    const { user } = useContext(UserContext);
    const { register, handleSubmit } = useForm();


    console.log(window.sessionStorage.getItem("token"));

    const passEdit = async (formValues : any) => {  
        const response = await axios.post(API_URL + "/loja/perfil/autenticar-senha", formValues) //segundo parametro seriam headers
        console.log(response);
        if(response.data.length == 0){
            alert("Senha Invalida.");
        } else{
            window.sessionStorage.setItem("token", response.data)
        }
    }

    return(
    <>
    <Header></Header>
    <section id="section-principal">
		<div className="base">
			<span id="accountIcon" className="material-symbols-outlined">account_circle</span>
			<h1>Meus dados</h1>

			<form className="formDados" onSubmit={handleSubmit(passEdit)}>
                <input id="idCliente" {...register("idCliente")} type="hidden" required  value={user.cod_cli}/>
                <input id="email" {...register("email")} type="hidden" required  value={user.email_cli}/>
				<label htmlFor="senha">Sua senha atual: </label> 
                <input id="senha" {...register("senha")} type="password" required maxLength={30}
					placeholder="Sua Senha *" />

				<button id="editar" type="submit">Enviar</button>
			</form>
		</div>
	</section>
    <Footer></Footer>
    </>
    )
}