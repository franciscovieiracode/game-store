import React from 'react'
import './Navbar.css'
import logo from '../assets/logo.png'
import cart from '../assets/cart.jpg'
import search_icon from '../assets/search_icon.png'
import { Link } from 'react-router-dom'
import { useUser } from '../../contexts/UserContext';


export const Navbar = () => {

  const { user, logout } = useUser();

  return (
    <div className='navbar'>
      <Link to="/">
        <div className="nav-logo">
          <img src={logo} alt="Logo" />
          <p>GAMERSTORE</p>
        </div>
      </Link>
      <ul className='nav-menu'>
        <li><Link to="/pc">PC</Link></li>
        <li><Link to="/playstation">Playstation</Link></li>
        <li><Link to="/xbox">XBOX</Link></li>
        <li><img src={search_icon} alt="" /></li>
      </ul>
      <div className="nav-login-cart">

        <div>
          {user ?(
            <>
            <span>Hello, {user.name}</span>
            <button onClick={logout}>Logout</button>
            </>
          ):(
            <Link to="/login"><button>Login</button></Link>
          )}
        
        </div>
        <Link to="/cart"><img src={cart} alt="Cart" /></Link>
        <div className="nav-cart-count">0</div>
      </div>
    </div>
  )
} 