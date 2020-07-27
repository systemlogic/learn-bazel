import unittest
import platform
from Hello import Hello

class TestStringMethods(unittest.TestCase):

    def test_upper(self):
        self.assertEqual('foo'.upper(), 'FOO')


    def test_split(self):
        obj = Hello().platform()
        print(obj)
        self.assertEqual(platform.platform(),obj)

if __name__ == '__main__':
    unittest.main()

