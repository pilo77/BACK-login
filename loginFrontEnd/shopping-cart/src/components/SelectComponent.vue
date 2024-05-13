<template>
    <ion-list>
      <ion-item>
        <ion-select aria-label="select" placeholder="Género">
          <ion-select-option value="apples">Hombre</ion-select-option>
          <ion-select-option value="oranges">Mujer</ion-select-option>
          <ion-select-option value="bananas">Prefiero no decir</ion-select-option>
        </ion-select>
      </ion-item>
    </ion-list>
  </template>
  
  <script>
    import { IonItem, IonList, IonSelect, IonSelectOption } from '@ionic/vue';
    import { defineComponent } from 'vue';
  
    export default defineComponent({
      components: { IonItem, IonList, IonSelect, IonSelectOption },
    });
  </script>
