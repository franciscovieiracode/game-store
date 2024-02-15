import React from 'react'
import { Hero } from '../components/hero/Hero'
import { Trending } from '../components/trending/Trending'
import { MostSold } from '../components/most-sold/MostSold'

export const Home = () => {
  return (
    <div>
      <Hero />
      <Trending/>
      <MostSold/>
    </div>
  )
}
