import { Component } from 'react';
import JavaIcon from '../../assets/favicon.ico'
import Menu from './menu';
import { Link } from 'react-router-dom';



class Header extends Component<any, any>{
	
	render() {
	
		return(
			<header>
			<Link to="/loja/"><img alt="Icone do Java" src={JavaIcon} id="logo"/></Link>
			<div id="pesquisar">
				<form action="/loja/pesquisar" method="get">
					<input type="text" id="pesquisa" name="pesquisa" placeholder="Pesquisar"/>
				</form>
			</div>
			<Menu></Menu>
			</header>
		);
	}
}

export default Header;