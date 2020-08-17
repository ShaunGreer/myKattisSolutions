import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let eachCase = init (splitOn "\n" contents)
  printAns (compute eachCase)

compute :: [String] -> [String]
compute (x:xs)
  | (x!!0) == '0' && (x!!2) == '0' = []
  | otherwise = (output (read ((splitOn " " x)!!0) :: Int) (read ((splitOn " " x)!!1)::Int)) : compute xs

output :: Int -> Int -> String
output sweet sour
  | sweet + sour == 13 = "Never speak again."
  | sour > sweet = "Left beehind."
  | sweet > sour = "To the convention."
  | otherwise = "Undecided."

printAns :: [String] -> IO()
printAns [] = return()
printAns (x:xs) = do
  putStrLn (x)
  printAns xs
