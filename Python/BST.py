import sys

class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None
		
	def insert(self, data):
		if self.data is None:
			self.data = data
		else:
			if self.data > data:
				if self.left is None:
					self.left = Node(data)
				else:
					self.left.insert(data)
			elif self.data < data:
				if self.right is None:
					self.right = Node(data)
				else:
					self.right.insert(data)
					
	def lookup(self, data, parent = None):
		if self.data > data:
			if self.left is not None:
				return self.left.lookup(data, self)
			return None, None
		elif self.data < data:
			if self.right is not None:
				return self.right.lookup(data, self)
			return None, None
		else:
			return self, parent				
	
	def child_count(self):
		c = 0
		if self.left is not None:
			c += 1
		if self.right is not None:
			c += 1
		return c	
		
	def delete(self, data):
		n, par = self.lookup(data)
		if n is not None:
			c = self.child_count()
		if c == 0:
			if par:
				if par.left is n:
					par.left = None
				else:
					par.right = None
				del n
			else:
				self.data = None
		
		elif c == 1:
			if n.left:
				child = n.left
			else:
				child = n.right	
			if par:
				if par.left is n:
					par.left = child
				else:
					par.right = child
				del n
			else:
				self.left = child.left
				self.right = child.right
				self.data = child.data
		
		else:
			par = n
			successor = n.right
			while successor.left:
				par = successor
				successor = successor.left
			
			n.data = successor.data		
			if par.left == successor:
				par.left = successor.right
			else:
				par.right = successor.right
	
	def print_inorder(self):
		if self.left:
			self.left.print_inorder()
		print self.data
		if self.right:
			self.right.print_inorder()	
						
	def print_preorder(self):
		print self.data
		if self.left:
			self.left.print_preorder()
		if self.right:
			self.right.print_preorder()
	
	def print_postorder(self):
		if self.left:
			self.left.print_preorder()
		if self.right:
			self.right.print_preorder()
		print self.data											
				
n1 = Node(10)
n1.insert(15)
n1.insert(9)
n1.insert(1)
n1.insert(14)
print "Inorder"
n1.print_inorder()
print "Preorder"
n1.print_preorder()	
print "Postorder"
n1.print_postorder()
m, par = n1.lookup(15)
print m, par
print "Postorder"
n1.print_postorder()
n1.delete(1)
print "Postorder"
n1.print_postorder()						
					
				
					
					
												
										