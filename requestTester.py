import requests


class SpringAPItester:
    def __init__(self):
        self.address = "http://localhost:8080/"

    def getAll(self):
        # Get all the data from the database
        r = requests.get(self.address + "greeting/all")
        print(r.text)

    def insert(self, ColA, ColB):
        # Insert new record into the database
        payload = {'ColA': ColA, 'ColB': ColB}
        r = requests.post(self.address + "greeting", params=payload)
        print(r.text)


if __name__ == "__main__":
    tester = SpringAPItester()

    # Test getting all data
    tester.getAll()

    # Test inserting data
    #tester.insert("Showing JP", 159)
