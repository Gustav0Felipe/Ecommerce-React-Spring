import { useContext } from 'react'
import { CartContext } from '../context/cartContext'
import { Footer } from '../components/footer/footer'
import Header from '../components/header/header'

export default function Cart () {

  const { cartItems, addToCart, removeFromCart, deleteFromCart, clearCart, getCartTotal, updateOrder } = useContext(CartContext)

  return (
    <>    
    <Header></Header>
    <section>    
      <h1><span className="material-symbols-outlined">shopping_cart</span> MEU CARRINHO</h1>
    <div id="resumo">
      <h2>Resumo</h2>
      {
          cartItems.length > 0 ? (
      <p>Total: {getCartTotal()}</p> ) : (
        <h1>Your cart is empty</h1>
      )}
    </div>
      <div>
        <div id="carrinho">
          <h3>Produto</h3>
          <ol id="carrinho_list">
          {cartItems.map((item : any) => (
            <div key={item.id}>
              <li>
              <img className="miniatura_produto" src="imagens/${produto.getId()}.png" alt={item.nome_prod}/>
              
              <p>
              <button
                  onClick={() => {
                    addToCart(item)
                  }}
                >
                  +
                </button>
                {item.quantity}
                <button
                  onClick={() => {
                    removeFromCart(item)
                  }}
                >
                  -
                </button>
                <button type="button" onClick={() => {deleteFromCart(item)}}><span className="material-symbols-outlined">delete</span></button>
              </p>
              
             
            </li>

            <li>
            <p className="prod_name">{item.nome_prod}</p>
            </li>
            </div>
              
          ))}  
          </ol>
        </div>
        {
          <button onClick={() => {clearCart()}}>
            Clear cart
          </button>
        }
      </div>

      <div id="finalizarDiv">
        <button onClick={() => {updateOrder()}} id="finalizar" type="button"><span className='material-symbols-outlined'>shopping_cart</span> FINALIZAR PEDIDO</button>
      </div>
      </section>
      <Footer></Footer>
      </>
    )
}
