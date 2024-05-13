<template>
    <ion-item :lines="lines" :detail="detail" :detail-icon="detailIcon">
      <ion-label>{{ label }}</ion-label>
      <ion-input v-bind="$attrs" :type="type" :value="value" :placeholder="placeholder" :clearInput="clearInput" :debounce="debounce" :disabled="disabled" :maxlength="maxlength" :min="min" :max="max" :step="step"></ion-input>
    </ion-item>
  </template>
  
  <script lang="ts">
  import { IonItem, IonLabel, IonInput } from '@ionic/vue';
  import { defineComponent } from 'vue';
  
  export default defineComponent({
    components: { IonItem, IonLabel, IonInput },
    props: {
      label: {
        type: String,
        required: true
      },
      value: {
        type: [String, Number],
        required: true
      },
      lines: {
        type: String,
        default: 'full'
      },
      detail: {
        type: Boolean,
        default: false
      },
      detailIcon: {
        type: String,
        default: ''
      },
      type: String,
      placeholder: String,
      clearInput: Boolean,
      debounce: Number,
      disabled: Boolean,
      maxlength: Number,
      min: Number,
      max: Number,
      step: Number
    }
  });
  </script>
  





