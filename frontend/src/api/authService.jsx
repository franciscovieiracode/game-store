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
          throw new Error('Login failed');
        }
      
        return await response.json();
      }
    
}

export default authService;