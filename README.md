# 📄 SimpleApp
SimpleApp è unA BASICA applicazione sviluppata utilizzando Java e Maven, containerizzata con Docker e distribuita utilizzando Jenkins e Ansible. Questa applicazione è progettata per dimostrare un flusso di lavoro CI/CD automatizzato, che include il checkout del codice, la compilazione, la creazione e il push dell'immagine Docker, e infine la distribuzione su un ambiente di produzione.

## 🌟 Funzionalità
Integrazione continua: Utilizzo di Jenkins per gestire il processo di build e test.
Containerizzazione: Creazione di un'immagine Docker per l'applicazione.
Automazione della distribuzione: Utilizzo di Ansible per la distribuzione dell'applicazione.
Notifiche Slack: Integrazione delle notifiche per tenere traccia dello stato delle build.

### ⌛Tecnologie Utilizzate
- Java
- Maven
- Docker
- Jenkins
- Ansible
- Slack

## ℹ️ Istruzioni per l'uso
Clona il repository:

```py
git clone https://github.com/BuBiNo-MoB/SimpleApp.git
cd SimpleApp
```
Compila l'applicazione:
```py
mvn clean package
```

Costruisci l'immagine Docker:
```py
docker build -t myapp .
```

Esegui l'immagine Docker:
```py
docker run -d -p 8080:8080 myapp
```
