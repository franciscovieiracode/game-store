import React from 'react'
import './Footer.css'
import footer_logo from '../assets/logo.png'
import instagram_logo from '../assets/instagram.png'
import x_logo from '../assets/x.jpg'
import discord_logo from '../assets/discord.png'

export const Footer = () => {


  const openDetailFooter= () =>{
    alert("Empresa op")
  }

  return (
    <div className='footer'>
        <div className="footer-logo">
          <img src={footer_logo} alt="" />
          <p>GAMERSTORE</p>
        </div>
        <ul className='footer-links'>
          <li onClick={openDetailFooter}>Company</li>
          <li>Products</li>
          <li>Offices</li>
          <li>About</li>
          <li>Contact</li>
        </ul>
        <div className="footer-social-icon">
          <div className="footer-icons-container">
            <img src={instagram_logo} alt="" />
          </div>
          <div className="footer-icons-container">
            <img src={x_logo} alt="" />
          </div>
          <div className="footer-icons-container">
            <img src={discord_logo} alt=""  />
          </div>
        </div>
        <div className="footer-copyright">
          <hr />
          <p>Copyright @ 2024 - All Rights Reserved</p>
        </div>
    </div>
  )
}
