import { useEffect, useState } from "react";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import axios from "axios";
import { useParams } from "react-router-dom";

const API_URL = 'http://localhost:8080';

export function CadastroVerificar(){   
    var { code } = useParams();
    const [verificado, setVerificado] = useState(false);
    const [handleErrorMessage, setHandleErrorMessage] = useState(false);

    const registrateUser = () => {  
        const fetchValidation = async () => {
            const response = await axios.get(API_URL + "/loja/cadastro/verificar?code=" + code) //segundo parametro seriam headers
            console.log(response);
            if(response.data == true){
                setVerificado(true);
            }else{
                setHandleErrorMessage(true);
            }
            return response;
        }
        fetchValidation();
    }
    useEffect(() => {
        const response = registrateUser()
        
        return response;
        }, []);

    return(
    <>  
    <Header></Header>
    <section id="section-principal">
		<div id="cadastro">
			<span id="createUserIcon" className="material-symbols-outlined">person_add</span>
			{ verificado &&
            <h1>Conta Verificada com Sucesso.</h1>
            }
            {!handleErrorMessage && !verificado && <h1>Verificando...</h1>}
            {handleErrorMessage && <h1>Conta já ativada ou Codigo errado.</h1>}
        </div>
	</section>
    <Footer></Footer>
    </>

    );


}