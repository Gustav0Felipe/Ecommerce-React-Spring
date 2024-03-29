import { createContext, useState, useEffect } from 'react'


export const UserContext = createContext<any>('');

export const UserProvider = ({ children } : any) => {
    var check : any = 0;
    if(localStorage.getItem("userPerfil") != null){
        check = localStorage.getItem("userPerfil");
    }else{
        check = "";
    }

    const [user, setUser] = useState<any>(localStorage.getItem('userPerfil') ? JSON.parse(check) : [])
    
    const userLogin = (user : any) => {
        setUser(user);
        localStorage.setItem("userPerfil", JSON.stringify(user));
      };

    const userLogout = () => {
      setUser([]);
      localStorage.removeItem("userPerfil");
    }
   
      useEffect(() => {
        localStorage.setItem("userPerfil", JSON.stringify(user));
      }, [user]);
    
      useEffect(() => {
        const user = localStorage.getItem("userPerfil");
        if (user) {
          setUser(JSON.parse(user));
        }
      }, []);
    
      return (
        <UserContext.Provider
          value={{
            user,
            userLogin,
            userLogout,
          }}
        >
          {children}
        </UserContext.Provider>
      );
    };