import React from 'react'
import './MostSold.css'
import data_games from '../assets/data sold'
import { Game } from '../game/Game'

export const MostSold = () => {
    return (
        <div className='sold'>
            <h1>MOST SOLD GAMES</h1>
            <hr />
            <div className="sold-games">
                {data_games.map((game, i)=>{
                    return <Game key ={i} id={game.id} name={game.name} image={game.image} new_price={game.new_price} old_price={game.old_price}/>
                })}
            </div>
        </div>
      )
}
