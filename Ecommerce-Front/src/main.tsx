import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import {QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { CartProvider } from './context/cartContext.tsx'
import { UserProvider } from './context/userContext.tsx'

const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById('root')!).render(
  
 // <React.StrictMode>
    <QueryClientProvider client={queryClient}>
       <UserProvider>
        <CartProvider>
          <App/>
          </CartProvider>
      </UserProvider>
    </QueryClientProvider>
  //</React.StrictMode>,
)
