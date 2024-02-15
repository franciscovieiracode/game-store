import React from 'react'
import './Trending.css'
import data_games from '../assets/data'
import { Game } from '../game/Game'

export const Trending = () => {
  return (
    <div className='trending'>
        <h1>TRENDING</h1>
        <hr />
        <div className="trending-games">
            {data_games.map((game, i)=>{
                return <Game key ={i} id={game.id} name={game.name} image={game.image} new_price={game.new_price} old_price={game.old_price}/>
            })}
        </div>
    </div>
  )
}
