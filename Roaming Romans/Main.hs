import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let x = read contents :: Float
  putStrLn (show (engToRoman x))

engToRoman :: Float -> Int
engToRoman x = round (1000 * ((x * 5280) / 4854))
