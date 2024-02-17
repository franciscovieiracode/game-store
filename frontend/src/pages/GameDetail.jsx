import React from 'react'
import data_game from '../components/assets/data single'
import '../pages/css/GameDetail.css'

export const GameDetail = () => {
  return (
    <div className='game-detail'>
      <div className="left">
        <div className="big-image">
          <img src={data_game.image} height={500} alt="Game Image" />
        </div>
        <div className="small-image">
          <img src={data_game.small_images[0]} height={106} alt="" />
          <img src={data_game.small_images[1]} height={106} alt="" />
        </div>
        <div className="description">
          <p>{data_game.about}</p>
        </div>
      </div>
      <div className="right">
          <div className="info">
            {data_game.name}
          </div>
          <div className="stock">
            <p>{data_game.stock}</p>
            <p>{data_game.console}</p>
          </div>
          <div className="prices">
            <p className='old-price'>{data_game.old_price}€</p>
            <p className='new-price'>{data_game.new_price}€</p>
          </div>
          <div className="btn">
            <button>Add to cart</button>
          </div>
      </div>
    </div>
  )
}
