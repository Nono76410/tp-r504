def f(a,b):
	
	if not type(a) is int :
		raise TypeError("Only Integers are Allowed")
	if not type(b) is int : 
		raise TypeError("Only Integers are Allowed")

	if a == 0 and b < 0:
    		raise ValueError("L'élévation à la puissance d'un nombre négatif n'est pas définie pour zéro.")	
  
	return a**b


