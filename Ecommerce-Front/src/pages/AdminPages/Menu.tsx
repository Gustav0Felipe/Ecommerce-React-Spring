import { Link, Navigate } from "react-router-dom";
import Header from "../../components/header/header";
import { Footer } from "../../components/footer/footer";

export function AdminMenu(){
    return(
    <>
    {window.sessionStorage.getItem("isAdmin") != "true" && <Navigate to="/loja/login-admin"></Navigate> }
    <Header></Header>
    <section id="section-principal-admin">
	<h1>Menu de gerenciamento</h1>
		<ol id="adminOptions">
			<li><Link to="/loja/admin/cadastrar-produto"><button>Cadastrar Produto</button></Link></li>
			<li><Link to="/loja/admin/pedidos"><button>Listar Pedidos</button></Link></li>
			<li><Link to="/loja/login-admin"><button onClick={() => {window.sessionStorage.removeItem("isAdmin")} }><span className="material-symbols-outlined" id="exitIcon">logout</span></button></Link></li>
		</ol>
    </section>
    <Footer></Footer>
    </>
    )
}