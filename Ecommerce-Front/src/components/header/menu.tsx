import { Component } from 'react';
import { Link } from 'react-router-dom';

class Menu extends Component<any, any>{
	
	constructor(props : any){
		super(props);
			this.state = {
				open: false,
			};

		this.handleClick = this.handleClick.bind(this);
		
		}
	handleResize = () => {
		if(window.innerWidth >= 769){
			this.setState({open: true})
		}else{
			this.setState({open: false})
		}
		
	};

	handleClick = () => {
		if (this.state.open) {
			this.setState({ open: false });
		}else{
            this.setState({open : true});
        }
	};
	
	render() {
		window.addEventListener("resize", this.handleResize);

		if(!this.state.open && window.innerWidth < 769){
			return(
                <><span id="burguer" className="material-icons" onClick={this.handleClick}>menu</span></>
            )
		}
		return(
        <>
            <span id="burguer" className="material-icons" onClick={this.handleClick}>menu</span>
			<nav id="menu">
				<ul>
					<li><Link to={"/loja/"}> Ofertas do Dia </Link></li>
					<li><Link to={"/loja/login"}> Entre </Link></li>
					<li><Link to={"/loja/perfil"}> Minha conta </Link></li>
					<li><Link to={"/loja/cadastro"}> Crie a sua conta </Link></li>
					<li><Link to={"/loja/cart"}>
							<span id="cart" className="material-symbols-outlined">shopping_cart</span> 
						</Link>
					</li>
				</ul>
			</nav>
        </>
        	);
		}
}

export default Menu;
