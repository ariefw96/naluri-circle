import { useState } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const backendBaseUrl = 'http://localhost:8080'
  const [pi, setPi] = useState(0)
  const [diameter, setDiameter] = useState(0) // <-- ini untuk textbox
  const [circumference, setCircumference] = useState('')

  const getPi = async () => {
    try {
      const response = await axios.get(`${backendBaseUrl}/get-pi`)
      setPi(response.data.pi)
    } catch (error) {
      console.error('Failed to get Pi:', error)
    }
  }

  const reset = async () => {
    try {
      const response = await axios.get(`${backendBaseUrl}/reset`)
      setPi(response.data.pi)
      setDiameter(0)
      setCircumference('')
    } catch (error) {
      console.error('Failed to reset Pi:', error)
    }
  }

  const calculate = async () => {
    try {
      const response = await axios.post(`${backendBaseUrl}/calculate-circumference`, {
        pi: pi,
        diameter: diameter
      })
      setCircumference(response.data.circumference)
    } catch (error) {
      console.error('Failed to calculate circumference:', error)
    }
  }

  return (
    <>
      <div>
        <button onClick={getPi}>Click to get Pi</button>
        <p>Pi is : {pi}</p>

        <button onClick={reset}>Click to reset Pi</button>
        <br></br>
        <div>
          <p>Enter diameter of sun (in KM): </p>
          <input
          value={diameter}
          onChange={(e) => setDiameter(e.target.value)}
          placeholder="Diameter (in KM)"
        />
        </div>

        <button onClick={calculate}>Calculate</button>

        <p>Circumference of the sun is : {circumference}</p>
      </div>
    </>
  )
}

export default App
