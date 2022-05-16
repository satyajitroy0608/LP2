# Develop an elementary chatboat for any suitable customer interaction application.

# Banking Customer Service
# User can query about loan details, FD details, account opening and other procedures

import random
print("\nWelcome to the cupcakes Shop!!!\n")
print("BOT: What do you want me to call you?")
user_name = input()
print("Hii", (user_name),"!!")

bot_template = "BOT : {0}"
user_template = user_name + " : {0}"

name = "Cupcakes shop Assistant" 
flavours= "Mango, Chocolate, vanilla " 
price = "Mango-50, Chocolate-70, Vanilla-60 (per piece)"
time = "10 AM to 9 PM"
bye = "Have a nice day!"

responses = { 
"what's your name?": [ "They call me {0}".format(name), "I usually go by {0}".format(name), 
"My name is the {0}".format(name) ],

"what's today's available flavours?": [ 
"The available flavours are {0}! Grab your favourite!".format(flavours), 
"It's {0} !!".format(flavours), 
"Let me check, the flavours available today are {0}!".format(flavours)],

"what are the timings of the shop?": [ 
"The shop is opened from {0}! see you there! :)".format(time),],

"how are you?": [ 
"I am fine! Hope you too!:)", 
"I am doing good!", ],

"What are the prices of the cakes?": [ 
"Umm let me check, got it ,the prices are {0}".format(price), 
"{0}! are the prices! Pick your favourites and enjoy!!:)".format(price), 
"Ohh just so afforable!! {0}! Enjoy!:)".format(price), ],

"": [ 
"Hey! Are you there?", 
"What do you mean by saying nothing?", 
"I didn't get your question :\") ",
"Sometimes saying nothing tells a lot :)", ],

"Good-bye": [
"Have a nice day!",
"See you again!"
],

"default": [
"this is a default message"] }


def respond(message):
    if message in responses: 
        bot_message = random.choice(responses[message])
    else: 
        bot_message = random.choice(responses["default"])
    return bot_message


def related(x_text): 
  if "name" in x_text: 
    y_text = "what's your name?"
  elif "flavours" in x_text: 
    y_text = "what's today's available flavours?"
  elif "price" in x_text: 
    y_text = "What are the prices of the cakes?"
  elif "time" in x_text: 
    y_text = "what are the timings of the shop?"
  elif "how are" in x_text: 
    y_text = "how are you?"
  elif "bye" in x_text:
    y_text = "Good-bye"
  else: 
    y_text = ""
  return y_text


def send_message(message): 
  print(user_template.format(message)) 
  response = respond(message) 
  print(bot_template.format(response))

while 1: 
  my_input = input() 
  my_input = my_input.lower() 
  related_text = related(my_input) 
  send_message(related_text)
  if my_input == "exit" or my_input == "stop": 
    break
