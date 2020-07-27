#!/usr/bin/python
from http.server import BaseHTTPRequestHandler, HTTPServer


#This class will handles any incoming request from
#the browser
class myHandler(BaseHTTPRequestHandler):
    #Handler for the GET requests
    def do_GET(self):
        self.send_response(200)
        self.send_header('Content-type', 'text/html')
        self.end_headers()
        # Send the html message
        self.wfile.write("Hello python World !")
        return

    def do_POST(self):
        self.send_response(201)
        self.send_header('Content-type', 'text/html')
        self.end_headers()
        # Send the html message
        self.data_string = str(self.rfile.read(int(self.headers['Content-Length'])))
        self.wfile.write(self.data_string)
        parsed_json = self.data_string
        print( parsed_json)
        return

def main():
    try:
        #Create a web server and define the handler to manage the
        #incoming request
        port = 8080
        server = HTTPServer(('', port), myHandler)
        print('Started httpserver on port ', port)
        server.serve_forever()

    except KeyboardInterrupt:
        print('^C received, shutting down the web server')
        server.socket.close()


if __name__ == '__main__':
    # Execute the Python process running within the CEDP environment.
    main()
