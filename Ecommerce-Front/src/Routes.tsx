import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Compra from "./pages/Compra";
import Cart from "./pages/Cart";
import { Perfil } from "./pages/Perfil";
import { Login } from "./pages/Login";
import { Cadastro } from "./pages/Cadastro";
import { EditarPerfil } from "./pages/PerfilEditar";
import { AutenticarSenha } from "./pages/PerfilEditarSenhaAutenticar";
import { EditarSenha } from "./pages/PerfilEditarSenha";
import { AdminMenu } from "./pages/AdminPages/Menu";
import { CadastrarProduto } from "./pages/AdminPages/CadastrarProduto";
import { Pedidos } from "./pages/AdminPages/Pedidos";
import { DetalhesDoPedido } from "./pages/AdminPages/PedidoDetalhes";
import { CadastroVerificar } from "./pages/CadastroVerificar";
import { Payment } from "./pages/Payment";

function AppRoute( ){

   
    return ( 
        <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home></Home>}></Route>                
                <Route path="/loja" element={<Home></Home>}></Route>

                <Route path="/comprar/:id" Component={Compra}></Route> 

                <Route path="/loja/cart" Component={Cart}></Route>
                <Route path="/loja/cart/payment" Component={Payment}></Route>

                <Route path="/loja/login" Component={Login}></Route>
                <Route path="/loja/cadastro" Component={Cadastro}></Route>
                <Route path="/loja/cadastro/verificar/:code" Component={CadastroVerificar}></Route>
                <Route path="/loja/perfil" Component={Perfil}></Route>
                <Route path="/loja/perfil/editar" Component={EditarPerfil}></Route>
                <Route path="/loja/perfil/autenticar-senha" Component={AutenticarSenha}></Route>
                <Route path="/loja/perfil/editar-senha/:auth" Component={EditarSenha}></Route>

                <Route path="/loja/admin" Component={AdminMenu}></Route>
                <Route path="/loja/admin/cadastrar-produto" element={<CadastrarProduto></CadastrarProduto>}></Route>
                <Route path="/loja/admin/pedidos" Component={Pedidos}></Route>
                <Route path="/loja/admin/pedidos/:pedidoId" Component={DetalhesDoPedido}></Route>
            </Routes>
        </BrowserRouter>
        </>
    )
}

export default AppRoute;  
