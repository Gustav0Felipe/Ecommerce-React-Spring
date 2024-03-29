import { createContext, useState, useEffect, useContext } from 'react'
import { UserContext } from './userContext';
import axios from 'axios';
import { Pedido } from '../interface/PedidoDto';
import { OrderProduct } from '../interface/OrderProduct';

const API_URL = 'http://localhost:8080'

export const CartContext = createContext<any>('');

export const CartProvider = ({ children } : any) => {
    
    var check : any = 0;
    if(localStorage.getItem("cartItems") != null){
        check = localStorage.getItem("cartItems");
    }else{
        check = "";
    }

  const { user } = useContext(UserContext);
  const [cartItems, setCartItems] = useState<any>(localStorage.getItem('cartItems') ? JSON.parse(check) : [])

  const addToCart = (item : any) => {
    const isItemInCart = cartItems.find((cartItem : any) => cartItem.id_prod === item.id_prod);

    if (isItemInCart) {
      setCartItems(
        cartItems.map((cartItem : any) =>
          cartItem.id_prod === item.id_prod
            ? { ...cartItem, quantity: cartItem.quantity + 1 }
            : cartItem
        )
      );
    } else {
      setCartItems([...cartItems, { ...item, quantity: 1 }]);
    }
  };

  const removeFromCart = (item : any) => {
    const isItemInCart = cartItems.find((cartItem : any) => cartItem.id_prod === item.id_prod);

    if (isItemInCart.quantity === 1) {
      setCartItems(cartItems.filter((cartItem : any) => cartItem.id_prod !== item.id_prod));
    } else {
      setCartItems(
        cartItems.map((cartItem : any) =>
          cartItem.id_prod === item.id_prod
            ? { ...cartItem, quantity: cartItem.quantity - 1 }
            : cartItem
        )
      );
    }
  };
  const deleteFromCart = (item : any) => {
    const isItemInCart = cartItems.find((cartItem : any) => cartItem.id_prod === item.id_prod);

    if (isItemInCart.quantity > 0 ) {
      setCartItems(cartItems.filter((cartItem : any) => cartItem.id_prod !== item.id_prod));
    } 
  };
  const clearCart = () => {
    setCartItems([]);
  };

  const getCartTotal = () => {
    return cartItems.reduce((total: number, item: { val_prod: number; quantity: number; }) => total + item.val_prod * item.quantity, 0);
  };

  const updateOrder = () =>  {
    var items : OrderProduct[] = cartItems.map((item: { id_prod: any; quantity: any; }) => {
      return {
       id_prod: item.id_prod, 
       quantity: item.quantity
      }
    });
    const pedido : Pedido = {
      clienteId: user.id_cliente,
      nome: user.nome,
      cpf: user.cpf,
      produtos: items
    }
    if(pedido != null){
    const fetchData = async () => {
      const response = await axios.post(API_URL + "/loja/cart/subir-pedido", pedido, {
        headers:{
          'Authorization': user.token
        }
      
      }) 
      setCartItems([]);
      return response;
      }
    const response = fetchData();
    return response;
    }
  }

  useEffect(() => {
    localStorage.setItem("cartItems", JSON.stringify(cartItems));
  }, [cartItems]);

  useEffect(() => {
    const cartItems = localStorage.getItem("cartItems");
    if (cartItems) {
      setCartItems(JSON.parse(cartItems));
    }
  }, []);

  return (
    <CartContext.Provider
      value={{
        cartItems,
        addToCart,
        removeFromCart,
        deleteFromCart,
        clearCart,
        getCartTotal,
        updateOrder,
      }}
    >
      {children}
    </CartContext.Provider>
  );
};