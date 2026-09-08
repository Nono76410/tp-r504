import pytest 
import fonctions as f 

def test_1():
	assert f.f(2,3) == 8 
	assert f.f(2,2) == 4 

def test_2():
    assert f.f(-1, 2) == 1
    assert f.f(-1, 3) == -1
    assert f.f(-1, -1) == -1
    assert f.f(-1, -2) == 1
    assert f.f(-2, -1) == -0.5
