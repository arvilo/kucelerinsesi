/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors:{
        'sliderBg':'#F9F4F1',
        'primary-slider-color':'#FBE29F',
        'secondary-slider-color':'#FAEAC6',
        'slider-button-color':'#FB7E46',
        'login-color':'#FB7E46'
      },
      letterSpacing: {
        'extra-wide': '64px'  
      },
      borderRadius: {
        '12': '12px', 
      },
      letterSpacing: {
        '2-percent': '0.02em', 
      },
    },
  },
  plugins: [],
}
