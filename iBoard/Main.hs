import Data.Char

main = do
  contents <- getContents
  printAns . toBinary $ lines contents

printAns :: [String] -> IO()
printAns [] = return()
printAns (x:xs) = do
  if (count x '0') `mod` 2 == 0 && (count x '1') `mod` 2 == 0
    then putStrLn $ "free"
    else putStrLn $ "trapped"
  printAns xs

count :: String -> Char -> Int
count [] c = 0
count (x:xs) c
  | x == c = 1 + count xs c
  | otherwise = count xs c

makeLen7 :: String -> String
makeLen7 x
  | length x == 7 = x
  | otherwise = makeLen7 ('0' : x)

--Deal with list of Strings
toBinary :: [String] -> [String]
toBinary [] = []
toBinary (x:xs) = (bin x) : toBinary xs

--Deal with each individual String
bin :: String -> String
bin [] = []
bin (x:xs)
  | length (translate (ord x)) < 7 = (makeLen7 (translate (ord x))) ++ bin xs
  | otherwise = (translate (ord x)) ++ bin xs

--Deal with each char
translate :: Int -> String
translate 0 = "0"
translate n = reverse . helper $ n

--Helper for efficiency to avoid concatenation
helper :: Int -> String
helper 0 = []
helper n
  | n `mod` 2 == 1 = '1' : helper (n `div` 2)
  | otherwise = '0' : helper (n `div` 2)
