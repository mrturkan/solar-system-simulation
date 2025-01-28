# Solar System Simulation

## Overview
This project simulates the motion of celestial bodies in a solar system using Newton's laws of motion and universal gravitation. The simulation is implemented in Java using JavaFX for rendering. Users can observe the orbits of planets around the sun, represented with scaled distances and velocities for better visualization.

## Features
- Real-time simulation of planetary orbits.
- Accurate physics calculations based on:
  - Newton's law of gravitation.
  - Euler integration for updating positions and velocities.
- Scalable rendering with visually distinct colors for planets.

## Technologies Used
- **Java 17 or higher**

## Usage
1. Run the simulation.
2. Observe the planetary orbits.
3. Modify the initial conditions in the `MyPanel` or `SolarBody` classes to explore different scenarios.

## How It Works
### Physics Model
- **Gravitational Force:**
  
  $\[ F = \frac{G \cdot m_1 \cdot m_2}{r^2} \]$
  
  Each celestial body attracts every other body with a force proportional to their masses and inversely proportional to the square of the distance between them.

- **Velocity and Position Updates:**
  The simulation uses a time step to iteratively calculate the velocity and position of each body.

### Rendering
- Each celestial body is drawn as a circle with its size proportional to its radius.
- Orbits are visualized as trails of the planets' past positions.

## Customization
You can customize the simulation by editing the following:
- **Initial conditions:**
  Modify positions, velocities, and masses of celestial bodies in `Simulation`.
- **Time step:**
  Adjust the simulation's time granularity by changing the `TIMESTEP` constant.

---

Feel free to open issues or ask questions in the repository if you encounter any problems or have suggestions for improvement.


