main :: IO()
main = do
  contents <- getContents
  if contents !! 0 == 'E'
    then putStrLn (encode (drop 3 contents) 1 (contents !! 2))
    else putStrLn (decode (drop 2 contents))

encode :: String -> Int -> Char -> String
encode [] _ _ = []
encode (x:xs) count current
  | x == current = encode xs (count + 1) current
  | otherwise = [current] ++ (show count) ++ (encode xs 1 x)

decode :: String -> String
decode [] = []
decode [x] = [x]
decode (x:y:xs) = (charTimes x (read [y] :: Int)) ++ decode xs

charTimes :: Char -> Int -> String
charTimes c 0 = []
charTimes c i = c : charTimes c (i-1)
