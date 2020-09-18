import platform

class Hello :

  def __init__(self):
    print("Constructor")

  def platform(self):
    return platform.platform()

if __name__ == '__main__':
  obj = Hello().platform()
  print("OS version", obj)
