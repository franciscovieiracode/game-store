import React from 'react'

const authService= {

     async login(email, password) {
        const response = await fetch('http://localhost:8083/api/v1/auth/login', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ email, password }),
          credentials: 'include'
        });
      
        if (!response.ok) {
          let errorMessage = 'Login failed';
          try {
            const errorData = await response.json();
            errorMessage = errorData.message || errorMessage;
          } catch (e) {
          }
          throw new Error(errorMessage);
        }
      
        return await response.json();
      },

      async register(name, email, password) {
        const response = await fetch("http://localhost:8083/api/v1/auth/register", {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({email, password, name }),
          credentials: 'include'
        });
        if (!response.ok) {
          let errorMessage = 'Register failed';
          try {
            const errorData = await response.json();
            errorMessage = errorData.message || errorMessage;
          } catch (e) {
          }
          throw new Error(errorMessage);
        }
      
        return await response.json();
      }
    
}

export default authService;