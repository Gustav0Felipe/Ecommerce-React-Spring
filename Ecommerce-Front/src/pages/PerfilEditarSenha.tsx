import { useContext } from "react"
import { UserContext } from "../context/userContext";
import { useForm } from "react-hook-form";
import axios from "axios";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import { Navigate, useParams } from "react-router-dom";

const API_URL = 'http://localhost:8080';

export function EditarSenha(){
    const { user, userLogin } = useContext(UserContext);
    const { register, handleSubmit } = useForm();
    var { auth } = useParams();
    
    var autorizar = false;
    if(auth == "auth=" + window.sessionStorage.getItem("token")){
        autorizar = true;
    }else{
        autorizar = false;
        window.sessionStorage.removeItem("token");
    } 
    
    const passEdit = async (formValues : any) => {  
        const response = await axios.put(API_URL + "/loja/perfil/editar-senha", formValues) //segundo parametro seriam headers
        userLogin(response.data);
        window.sessionStorage.removeItem("token");
        console.log(response);
    }

    return(
    <>
    
    <Header></Header>
    <section id="section-principal">
		<div className="base">
			<span id="accountIcon" className="material-symbols-outlined">account_circle</span>
            {
            autorizar && <h1>Meus dados</h1> && <form className="formDados" onSubmit={handleSubmit(passEdit)}>
                <input id="idCliente" {...register("idCliente")} type="hidden" required  value={user.cod_cli}/>
                <input id="email" {...register("email")} type="hidden" required  value={user.email_cli}/>
				<label htmlFor="senha">Nova senha: </label> 
                <input id="senha" {...register("senha")} type="password" required maxLength={30}
					placeholder="Nova Senha *" />

				<button id="editar" type="submit">Enviar</button>
			</form> 
            } 
            {!autorizar && <Navigate to="/loja/perfil"></Navigate>}
		</div>
	</section>
    <Footer></Footer>
    </>
    )
}