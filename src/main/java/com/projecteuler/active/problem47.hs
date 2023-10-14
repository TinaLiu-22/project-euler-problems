-- Problem 47

prime :: Integral a => a -> Bool
prime x = takeWhile (==0) (map (div x) [1..])