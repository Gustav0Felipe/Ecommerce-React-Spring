import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import axios from "axios";
import { useForm } from "react-hook-form";
import { Navigate } from "react-router-dom";
import { useContext } from "react";
import { UserContext } from "../context/userContext";

const API_URL = 'http://localhost:8080';

export function Login(){
    
    const { user, userLogin } = useContext(UserContext);
    const { register, handleSubmit } = useForm();

    const loginValidate = async (formValues : any) => {  
            const response = await axios.post(API_URL + "/loja/login", formValues) //segundo parametro seriam headers
            if(response.data.length == 0){
                alert("Email ou senha Inválidos.");
            } else{
                userLogin(response.data);
            }
    }

    return (
        <>
        {user.cod_cli && <Navigate to="/loja/perfil" replace={true} />}
        <Header></Header>
        <section id="section-principal">
            <div className="login">
                <span id="accountIcon" className="material-symbols-outlined">account_circle</span>
                <h1>Fazer Login</h1>
                <p>Informe Email e Senha</p>
                <form onSubmit={handleSubmit(loginValidate)}>
                    <label htmlFor="email">Email:</label> 
                    <input id="email" {...register("email")} type="email" maxLength={255} required placeholder="Email *" autoComplete="on"/> 
                    <label htmlFor="senha">Senha:</label> 
                    <input id="senha" {...register("senha")} type="password" minLength={8} required placeholder="Senha *" autoComplete="on" />
                    <button id="cadastrar" type="submit">Enviar</button>
                </form>
            </div>
        </section>
        <Footer></Footer>
        </>
    )
}