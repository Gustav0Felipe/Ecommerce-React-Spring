import { useContext } from 'react'
import { CartContext } from '../context/cartContext'
import { Footer } from '../components/footer/footer'
import Header from '../components/header/header'
import { Link } from 'react-router-dom'

export default function Cart () {

  const { cartItems, addToCart, removeFromCart, deleteFromCart, clearCart, getCartTotal } = useContext(CartContext)

  return (
    <>    
    <Header></Header>
    <section>    
    <div id="resumo">
      <h1><span className="material-symbols-outlined">shopping_cart</span> MEU CARRINHO</h1>
      <h2>Resumo</h2>
      {
          cartItems.length > 0 ? (
      <p>Total: {getCartTotal()}</p> ) : (
        <h3>Você não tem itens no Carrinho.</h3>
      )}
    </div>
      <div>
        <div id="carrinho">
          <h3>Produto</h3>
          <ol id="carrinho_list">
          {cartItems.map((item : any) => (
            <li key={item.id_prod}>
              <p className="prod_name">{item.nome_prod}</p>
              <img className="miniatura_produto" src={item.image} alt={item.nome_prod}/>
              <p>
              <button
                  onClick={() => {
                    addToCart(item)
                  }}
                >
                <span>+</span>
                </button>
                {item.quantity}
                <button 
                  onClick={() => {
                    removeFromCart(item)
                  }}
                >
                <span>-</span>
                </button>
                <button type="button" onClick={() => {deleteFromCart(item)}}><span className="material-symbols-outlined">delete</span></button>
              </p>
            </li>
          ))}  
          </ol>
          <button id="limpar_carrinho" onClick={() => {clearCart()}}>
            Clear cart
          </button>
        </div>
        
        
      </div>

      <div id="finalizarDiv">
        <Link to="/loja/cart/payment"><span className='material-symbols-outlined'>shopping_cart</span> FINALIZAR PEDIDO</Link>
      </div>
      </section>
      <Footer></Footer>
      </>
    )
}
