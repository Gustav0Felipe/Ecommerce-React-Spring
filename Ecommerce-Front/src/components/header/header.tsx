import { Component } from 'react';
import JavaIcon from '../../assets/favicon.ico'
import Menu from './menu';



class Header extends Component<any, any>{
	
	render() {
	
		return(
			<header>
			<a href="/loja/"><img alt="Icone do Java" src={JavaIcon} id="logo"/></a>
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