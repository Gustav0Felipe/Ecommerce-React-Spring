import { Footer } from "../../components/footer/footer";
import Header from "../../components/header/header";
import axios from "axios";
import { useForm } from "react-hook-form";
import { Navigate } from "react-router-dom";
import { useState } from "react";

const API_URL = 'http://localhost:8080';

export function LoginAdmin(){
    
    const { register, handleSubmit } = useForm();
    const [needRedirect, setNeedRedirect] = useState(false);

    const loginValidate = async (formValues : any) => {  
            const response = await axios.post(API_URL + "/loja/login/admin", formValues) //segundo parametro seriam headers
            console.log(response);
            if(response.data == true){
                console.log("Concedendo Acesso")
                window.sessionStorage.setItem("isAdmin", "true");
                setNeedRedirect(true);
                console.log(needRedirect);
            } else{
                alert("Email ou senha Inválidos.");
            }
    }

    return (
        <>
        {needRedirect && <Navigate to="/loja/admin" replace={true} />}
        {window.sessionStorage.getItem("isAdmin") == "true" && <Navigate to="/loja/admin" replace={true} />}
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
                    <input id="senha" {...register("senha")} type="password" minLength={3} required placeholder="Senha *" autoComplete="on" />
                    <button id="cadastrar" type="submit">Enviar</button>
                </form>
            </div>
        </section>
        <Footer></Footer>
        </>
    )
}