import React, { createContext, useState, useEffect, useContext } from 'react';
import userService from '../api/userService'; 


const UserContext = createContext();

export const useUser = () => {
    return useContext(UserContext);
  };

export const UserProvider = ({ children }) => {
    const [user, setUser] = useState(null);
  
    useEffect(() => {
        const fetchUser = async () => {
          try {
            const userData = await userService.getUserData();
            setUser(userData);
            console.log(userData);
            
            
          } catch (err) {
            console.error("User fetch failed:", err);
          }
        };
    
        fetchUser();
      }, []); 
  
    const login = (userData) => {
      setUser(userData);
    };
  
    const logout = async () => {
        await userService.logout();
      setUser(null);
    };
  
    return (
      <UserContext.Provider value={{ user, login, logout, setUser }}>
        {children}
      </UserContext.Provider>
    );
  };