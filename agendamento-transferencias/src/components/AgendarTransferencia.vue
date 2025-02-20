<template>
  <div class="form-container">
    <h2>Agendar Transferência</h2>
    <form @submit.prevent="agendar" class="form-content">
      <div class="form-group">
        <label for="contaOrigem">Conta de Origem:</label>
        <input id="contaOrigem" v-model="transfer.contaOrigem" required placeholder="XXXXXXXXXX" />
      </div>
      <div class="form-group">
        <label for="contaDestino">Conta de Destino:</label>
        <input id="contaDestino" v-model="transfer.contaDestino" required placeholder="XXXXXXXXXX" />
      </div>
      <div class="form-group">
        <label for="valorTransferencia">Valor da Transferência:</label>
        <input id="valorTransferencia" type="number" v-model.number="transfer.valorTransferencia" required />
      </div>
      <div class="form-group">
        <label for="dataTransferencia">Data da Transferência:</label>
        <input id="dataTransferencia" type="date" v-model="transfer.dataTransferencia" required />
      </div>
      <button type="submit" class="btn-submit">Agendar</button>
    </form>
    <p v-if="mensagem" :class="{ erro: erro, sucesso: !erro }" class="mensagem">{{ mensagem }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'AgendarTransferencia',
  data() {
    return {
      transfer: {
        contaOrigem: '',
        contaDestino: '',
        valorTransferencia: null,
        dataTransferencia: ''
      },
      mensagem: '',
      erro: false
    }
  },
  methods: {
    async agendar() {
      try {
        await axios.post('http://localhost:8081/api/transferencias', this.transfer);
        this.mensagem = 'Transferência agendada com sucesso!';
        this.erro = false;
        this.$emit('transferenciaCriada');
        this.transfer = {
          contaOrigem: '',
          contaDestino: '',
          valorTransferencia: null,
          dataTransferencia: ''
        };
      } catch (error) {
        this.mensagem = error.response && error.response.data 
          ? error.response.data 
          : 'Ocorreu um erro ao agendar a transferência.';
        this.erro = true;
      }
    }
  }
}
</script>

<style scoped>
/* Container centralizado e responsivo */
.form-container {
  max-width: 500px;
  margin: 30px auto;
  padding: 25px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

/* Título */
.form-container h2 {
  text-align: center;
  margin-bottom: 20px;
  color: #333;
}

/* Formulário em coluna */
.form-content {
  display: flex;
  flex-direction: column;
}

/* Cada grupo de campo com espaçamento */
.form-group {
  margin-bottom: 15px;
  display: flex;
  flex-direction: column;
}

/* Estilização dos labels */
.form-group label {
  margin-bottom: 5px;
  font-weight: 600;
  color: #555;
}

/* Estilização dos inputs */
.form-group input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 1rem;
  transition: border-color 0.3s;
}

.form-group input:focus {
  outline: none;
  border-color: #007bff;
}

/* Botão */
.btn-submit {
  padding: 12px;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  color: #fff;
  font-size: 1.1rem;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 10px;
}

.btn-submit:hover {
  background-color: #0056b3;
}

/* Mensagem de feedback */
.mensagem {
  text-align: center;
  margin-top: 20px;
  font-weight: 600;
}

.erro {
  color: #d9534f;
}

.sucesso {
  color: #5cb85c;
}

/* Responsividade */
@media (max-width: 600px) {
  .form-container {
    margin: 20px;
    padding: 20px;
  }
}
</style>
