import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import axios from "axios";
import { useParams } from "react-router-dom";

const API_URL = 'http://localhost:8080';

export function CadastroVerificar(){   
    var { code } = useParams();

    const registrateUser = (formValues : any) => {  
        console.log(formValues);
        const fetchValidation = async () => {
            const response = await axios.get(API_URL + "/loja/cadastro/verificar?code=" + code) //segundo parametro seriam headers
            console.log(response);
            return response;
        }
        fetchValidation();
    }

    return(
    <>  
    <Header></Header>
    <section id="section-principal">
		<div id="cadastro">
			<span id="createUserIcon" className="material-symbols-outlined">person_add</span>
			<h1>Verificando Conta</h1>
            <button onClick={registrateUser}></button>
        </div>
	</section>
    <Footer></Footer>
    </>

    );


}