import React from 'react'
import './Game.css'
import { Link } from 'react-router-dom'


export const Game = (props) => {
  return (
    <div className="game"  >
      <Link to={`/game/${props.id}`} >
        <img src={props.image} alt="Cover" />
        <p>{props.name}</p>
        <div className="game-prices">
          <div className="game-price-new">
            {props.new_price}€
          </div>
          <div className="game-price-old">
            {props.old_price}€
          </div>
        </div>
      </Link>
    </div>
  )
}
