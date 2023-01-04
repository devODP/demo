// import the `Kafka` instance from the kafkajs library
const { Kafka } = require("kafkajs")

// the client ID lets kafka know who's producing the messages
const clientId = "my-consumer"
// brokers in the cluster
const brokers = ["kafka_host:9094"]
// topic to which we want to write messages
const topic = "KafkaTestTopic"

const kafka = new Kafka({ clientId, brokers })

const consumer = kafka.consumer({ groupId: clientId })

const consume = async () => {
	// to wait for the client to connect and subscribe to the given topic
	await consumer.connect()
	await consumer.subscribe({ topic })
	await consumer.run({
		// the function is called each time the consumer gets a new message
		eachMessage: ({ message }) => {
			// log message to std
			console.log(`received message:\n${message.value}`)
		},
	})
}

consume().catch((err) => {
	console.error("error in consumer: ", err)
})