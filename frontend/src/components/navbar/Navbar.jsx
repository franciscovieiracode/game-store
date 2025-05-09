import React, { useState } from 'react';
import './Navbar.css';
import logo from '../assets/logo.png';
import cart from '../assets/cart.jpg';
import search_icon from '../assets/search_icon.png';
import profile_icon from '../assets/profile_icon.png'; // add a user icon image
import { Link } from 'react-router-dom';
import { useUser } from '../../contexts/UserContext';
import { Menu } from '@headlessui/react';

export const Navbar = () => {
  const { user, logout } = useUser();
  const [showDropdown, setShowDropdown] = useState(false);
  

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
        <li><img src={search_icon} alt="Search" /></li>
      </ul>

      <div className="nav-login-cart">
        {user ? (
          <div className="nav-profile">
            <img
              src={profile_icon}
              alt="Profile"
              className="profile-icon"
              onClick={() => setShowDropdown(!showDropdown)}
            />
            {showDropdown && (
              <div className="profile-dropdown">
                <Link to="/profile">My Account</Link>
                <Link to="/orders">Orders</Link>
                <button onClick={logout}>Logout</button>
              </div>
            )}
          </div>
        ) : (
          <Link to="/login"><button>Login</button></Link>
        )}
        
        <Link to="/cart">
          <img src={cart} alt="Cart" />
        </Link>
        <div className="nav-cart-count">0</div>
      </div>
    </div>
  );
};
