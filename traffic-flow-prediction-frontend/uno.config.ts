// uno.config.ts
import {
    defineConfig,
    presetAttributify,
    presetIcons,
    presetTypography,
    presetUno,
    presetWebFonts,
    transformerDirectives,
    transformerVariantGroup,
  } from 'unocss'
  
  export default defineConfig({
    theme: {
      // Custom theme
      colors: {
        brand: {
          primary: '#00f7ff',
          secondary: '#ff00ff',
        },
      },
      // Animation keyframes
      animation: {
        keyframes: {
          'spin': '{0% { transform: rotate(0deg); } 100% { transform: rotate(360deg); }}',
          'pulse': '{0%, 100% { opacity: 1; } 50% { opacity: 0.5; }}',
          'bounce': '{0%, 100% { transform: translateY(-25%); animation-timing-function: cubic-bezier(0.8,0,1,1); } 50% { transform: none; animation-timing-function: cubic-bezier(0,0,0.2,1); }}',
        },
        // Animation durations
        durations: {
          'default': '0.5s',
          '0': '0s',
          '75': '75ms',
          '100': '100ms',
          '150': '150ms',
          '200': '200ms',
          '300': '300ms',
          '500': '500ms',
          '700': '700ms',
          '1000': '1000ms',
        },
        // Animation timing functions
        timingFns: {
          'default': 'ease',
          'linear': 'linear',
          'ease-in': 'ease-in',
          'ease-out': 'ease-out',
          'ease-in-out': 'ease-in-out',
        },
        // Animation iteration counts
        counts: {
          'default': 'infinite',
          '1': '1',
          '2': '2',
          '3': '3',
        },
      }
    },
    presets: [
      presetUno(),
      presetAttributify(),
      presetIcons({
        scale: 1.2,
        warn: true,
      }),
      presetTypography(),
      presetWebFonts({
        provider: 'google',
        fonts: {
          sans: 'Roboto',
          mono: ['Fira Code', 'Fira Mono:400,700'],
        },
      }),
    ],
    transformers: [
      transformerDirectives(),
      transformerVariantGroup(),
    ],
    // Safelist required animations
    safelist: [
      'animate-spin',
      'animate-pulse',
      'animate-bounce',
    ],
    // Include these files in the scan
    include: [
      /\.astro$/, 
      /\.vue$/, 
      /\.ts$/,
      /\.tsx$/, 
      /\.jsx?$/, 
      /\.mdx?$/
    ],
  })