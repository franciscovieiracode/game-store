import { useState } from 'react';
import {useCart} from '../contexts/CartContext'

export const Cart = () => {
  const { items } = useCart();

  const totalPrice = items.reduce((sum, item) => {
    const platformData = item.gamePlatformModels.find(
      (platform) => platform.platformModel.platformEnums === item.platform
    );
    const itemTotal = platformData ? platformData.price * item.quantity : 0;
    return sum + itemTotal;
  }, 0);

  return (
    <div className="master">
      {items.map((item, index) => {
        const platformData = item.gamePlatformModels.find(
          (platform) => platform.platformModel.platformEnums === item.platform
        );
        
        const totalPerGame = platformData
          ? platformData.price * item.quantity
          : 0;
        return (
          <div key={item.gameId}>
            <img src={item.gameImg} height={200} alt="" />
            <div>{item.name}</div>
            <div>{item.quantity}</div>

            <div>{totalPerGame}</div>
          </div>
        );
      })}
      <div>
        <div>Total: {totalPrice}</div>
        <button>Delete</button>
      </div>
    </div>
  );
};
