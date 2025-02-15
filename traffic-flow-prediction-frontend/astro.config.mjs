// @ts-check
import { defineConfig } from 'astro/config';

import react from '@astrojs/react';
import UnoCSS from '@unocss/astro';

// https://astro.build/config
export default defineConfig({
  integrations: [react(),
    UnoCSS({
      injectReset: '@unocss/reset/tailwind.css',
    })
  ]
});