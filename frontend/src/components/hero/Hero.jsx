import React from 'react'
import hero from '../assets/hero.jpg'
import './Hero.css'

export const Hero = () => {
    return (
        <div className="hero">
            <div className='gameDetails'>
                <h2>Recently released</h2>
                <div className='gameDetailsName'>
                    <h3>Tekken 8</h3>
                    <p><span>39.58€</span></p>
                </div>
            </div>
            <div className='hero-image'>
                <img src={hero} alt="Hero" />
            </div>
        </div>
    )
}
