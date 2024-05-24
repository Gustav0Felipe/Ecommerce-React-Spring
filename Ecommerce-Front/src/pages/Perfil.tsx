import { useContext } from "react";
import { UserContext } from "../context/userContext";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import { Link, Navigate } from "react-router-dom";
import axios from "axios";

const API_URL = 'http://localhost:8080';

export function Perfil(){
    const { user, userLogout } = useContext(UserContext);
	
	const deleteAccount = async () => {
		const response = await axios.delete(API_URL + "/loja/perfil/deletar?idCliente=" + user.id_cliente, {
			headers : {
				'Authorization' : user.token
			}
		})
		userLogout();
		console.log(response);
		alert("Conta Excluida com Sucesso!, seus dados foram apagados.")
		return response;
	}
	console.log(user)
    return(
    <>
	{(user == null || !user.id_cliente) && <Navigate to="/loja/login"></Navigate>}
	
    <Header></Header>
        <section id="section-principal">
		<div className="perfil">
			<span id="accountIcon" className="material-symbols-outlined">account_circle</span>
			<h1>Minha Conta</h1>
			<h2>Informações de Acesso</h2>
			<ol>
				<li className="perfilDados">Nome:</li>
				<li>{user.nome}</li>
				<li className="perfilDados">Email:</li>
				<li>Gustavo.teste55@hotmail.com</li>
				<li className="perfilDados">Telefone:</li>
				<li>{user.telefone}</li>
				<li className="perfilDados">Cpf:</li>
				<li>433.422.144-59</li>
			</ol>
			<br/> 
			<Link to="/loja/perfil/editar"><button className="editButtons">EDITAR</button></Link> 
			<Link to="/loja/perfil/autenticar-senha"><button className="editButtons">MUDAR SENHA</button></Link>
			<button className="editButtons" onClick={userLogout}><span className="material-symbols-outlined" id="exitIcon">logout</span></button>
			<button className="editButtons" onClick= {deleteAccount}>Excluir Conta</button>
		</div>
	    </section>
    <Footer></Footer>
    </>
    )
}